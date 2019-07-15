package org.elementary.forum.entity.build;

import org.elementary.forum.entity.Topic;
import org.elementary.forum.entity.User;

import java.util.Date;

public class TopicBuilder implements IEntityBuilder<Topic>
{
  private Topic item;

  public TopicBuilder()
  {
    this.item = new Topic();
  }

  public TopicBuilder setTitle(String title)
  {
    item.setTitle(title);
    return this;
  }

  public TopicBuilder setDateCreated(Date date)
  {
    item.setDateCreated(date);
    return this;
  }

  public TopicBuilder setAuthor(User author)
  {
    item.setAuthor(author);
    return this;
  }

  @Override
  public Topic build() throws IllegalAccessException
  {
    if (item.getTitle() == null
        || item.getDateCreated() == null
        || item.getAuthor().getId() == 0)
    {
      throw new IllegalAccessException();
    }
    return item;
  }
}
