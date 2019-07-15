package org.elementary.forum.entity.build;

import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Votes;

public class VotesBuilder implements IEntityBuilder<Votes>
{
  private Votes item;

  public VotesBuilder()
  {
    item = new Votes();
  }

  public VotesBuilder setPost(Post post)
  {
    item.setPost(post);
    return this;
  }

  @Override
  public Votes build() throws IllegalAccessException
  {
    if (item.getPost().getId() == 0)
    {
      throw new IllegalAccessException();
    }
    return item;
  }
}
