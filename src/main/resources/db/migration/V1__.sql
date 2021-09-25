CREATE TABLE comment
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    text         VARCHAR(255)          NULL,
    post_id      BIGINT                NULL,
    created_date datetime              NULL,
    user_id      BIGINT                NULL,
    CONSTRAINT pk_comment PRIMARY KEY (id)
);

CREATE TABLE post
(
    post_id       BIGINT       NOT NULL,
    post_name     VARCHAR(255) NULL,
    url           VARCHAR(255) NULL,
    `description` LONGTEXT     NULL,
    vote_count    INT          NULL,
    user_id       BIGINT       NULL,
    created_date  datetime     NULL,
    id            BIGINT       NULL,
    CONSTRAINT pk_post PRIMARY KEY (post_id)
);

CREATE TABLE refresh_token
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    token        VARCHAR(255)          NULL,
    created_date datetime              NULL,
    CONSTRAINT pk_refreshtoken PRIMARY KEY (id)
);

CREATE TABLE subreddit
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    created_date  datetime              NULL,
    user_user_id  BIGINT                NULL,
    CONSTRAINT pk_subreddit PRIMARY KEY (id)
);

CREATE TABLE subreddit_posts
(
    subreddit_id  BIGINT NOT NULL,
    posts_post_id BIGINT NOT NULL
);

CREATE TABLE token
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    token        VARCHAR(255)          NULL,
    user_user_id BIGINT                NULL,
    expiry_date  datetime              NULL,
    CONSTRAINT pk_token PRIMARY KEY (id)
);

CREATE TABLE user
(
    user_id  BIGINT       NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    created  datetime     NULL,
    enabled  BIT(1)       NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

CREATE TABLE vote
(
    vote_id   BIGINT NOT NULL,
    vote_type INT    NULL,
    post_id   BIGINT NULL,
    user_id   BIGINT NULL,
    CONSTRAINT pk_vote PRIMARY KEY (vote_id)
);

ALTER TABLE subreddit_posts
    ADD CONSTRAINT uc_subreddit_posts_posts_postid UNIQUE (posts_post_id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_POSTID FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE comment
    ADD CONSTRAINT FK_COMMENT_ON_USERID FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_ID FOREIGN KEY (id) REFERENCES subreddit (id);

ALTER TABLE post
    ADD CONSTRAINT FK_POST_ON_USERID FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE subreddit
    ADD CONSTRAINT FK_SUBREDDIT_ON_USER_USERID FOREIGN KEY (user_user_id) REFERENCES user (user_id);

ALTER TABLE token
    ADD CONSTRAINT FK_TOKEN_ON_USER_USERID FOREIGN KEY (user_user_id) REFERENCES user (user_id);

ALTER TABLE vote
    ADD CONSTRAINT FK_VOTE_ON_POSTID FOREIGN KEY (post_id) REFERENCES post (post_id);

ALTER TABLE vote
    ADD CONSTRAINT FK_VOTE_ON_USERID FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE subreddit_posts
    ADD CONSTRAINT fk_subpos_on_post FOREIGN KEY (posts_post_id) REFERENCES post (post_id);

ALTER TABLE subreddit_posts
    ADD CONSTRAINT fk_subpos_on_subreddit FOREIGN KEY (subreddit_id) REFERENCES subreddit (id);