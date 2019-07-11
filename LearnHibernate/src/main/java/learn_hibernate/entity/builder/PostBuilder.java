package learn_hibernate.entity.builder;

import learn_hibernate.entity.Post;
import learn_hibernate.entity.Topic;
import learn_hibernate.entity.User;

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

  @Override
  public Post build() throws IllegalAccessException
  {
    if (item.getText() == null
        || item.getDateCreated() == null
        || item.getAuthor().getId() == 0
        || item.getTopic().getId() == 0)
    {
      throw new IllegalAccessException();
    }
    return item;
  }
}
