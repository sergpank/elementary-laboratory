CREATE TABLE IF NOT EXISTS groups_table(
id SERIAL,
group_name VARCHAR(100),
PRIMARY KEY(id)) engine InnoDB;

CREATE TABLE IF NOT EXISTS users(
    id SERIAL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    registration_date DATE NOT NULL,
    group_id BIGINT UNSIGNED,
    PRIMARY KEY(id),
    FOREIGN KEY (group_id)
    REFERENCES groups_table (id)
    ON DELETE CASCADE
) engine InnoDB;

CREATE TABLE IF NOT EXISTS topics(
    id SERIAL,
    topic_title VARCHAR(255) NOT NULL,
    date_created DATE NOT NULL,
    author_id BIGINT UNSIGNED,
    PRIMARY KEY(id),
    FOREIGN KEY (author_id)
    REFERENCES users (id)
    ON DELETE CASCADE
) engine InnoDB;

CREATE TABLE IF NOT EXISTS posts(
    id SERIAL,
    content TEXT NOT NULL,
    date_created DATE NOT NULL,
    author_id BIGINT UNSIGNED,
    topic_id BIGINT UNSIGNED,
    PRIMARY KEY(id),
    FOREIGN KEY (author_id)
    REFERENCES users (id)
    ON DELETE CASCADE,
    FOREIGN KEY (topic_id)
    REFERENCES topics (id)
    ON DELETE CASCADE
) engine InnoDB;

CREATE TABLE IF NOT EXISTS votes(
    id SERIAL,
    up_votes INT DEFAULT 0,
    down_votes INT DEFAULT 0,
    post_id BIGINT UNSIGNED,
    PRIMARY KEY(id),
    FOREIGN KEY (post_id)
    REFERENCES posts (id)
    ON DELETE CASCADE
) engine InnoDB;