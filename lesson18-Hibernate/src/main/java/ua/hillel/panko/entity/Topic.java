package ua.hillel.panko.entity;

import javafx.geometry.Pos;

import java.util.Date;
import java.util.List;

public class Topic
{
  private long id;
  private User author;
  private String title;
  private Date dateCreated;
  private List<Pos> posts;
}
