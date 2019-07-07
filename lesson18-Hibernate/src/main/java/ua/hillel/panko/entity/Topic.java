package ua.hillel.panko.entity;


import java.util.Date;
import java.util.List;

public class Topic
{
  private long id;
  private User author;
  private String title;
  private Date dateCreated;
  private List<Post> posts;
}
