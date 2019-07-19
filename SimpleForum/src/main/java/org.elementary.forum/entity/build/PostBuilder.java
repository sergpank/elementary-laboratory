package org.elementary.forum.entity.build;

import org.elementary.forum.entity.Post;
import org.elementary.forum.entity.Topic;
import org.elementary.forum.entity.User;
import org.elementary.forum.entity.Votes;

import java.util.Date;

public class PostBuilder implements IEntityBuilder<Post>
{
  private Post item;

  public PostBuilder()
  {
    item = new Post();
  }

  public PostBuilder setText(String text)
  {
    item.setText(text);
    return this;
  }

  public PostBuilder setDateCreated(Date date)
  {
    item.setDateCreated(date);
    return this;
  }

  public PostBuilder setAuthor(User author)
  {
    item.setAuthor(author);
    return this;
  }

  public PostBuilder setTopic(Topic topic)
  {
    item.setTopic(topic);
    return this;
  }

  public PostBuilder setParent(Post parent)
  {
    item.setParent(parent);
    return this;
  }

  public PostBuilder setVotes(Votes votes)
  {
    item.setVotes(votes);
    return this;
  }

  @Override
  public Post build() throws IllegalAccessException
  {
    if (item.getText() == null
        || item.getDateCreated() == null
        || item.getAuthor().getId() == null
        || item.getTopic().getId() == null)
    {
      throw new IllegalAccessException();
    }
    if(item.getVotes()==null)
    {
      Votes votes=new VotesBuilder()
          .setPost(item)
          .build();
      item.setVotes(votes);
    }
    return item;
  }
}
