package learn_hibernate.entity.builder;

import learn_hibernate.entity.Post;
import learn_hibernate.entity.Votes;

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
