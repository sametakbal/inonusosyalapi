create table user_followers
(
    user_id     uuid,
    follower_id uuid,
    last_update TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user
        FOREIGN KEY (user_id)
            REFERENCES users (id) on delete cascade,
    FOREIGN KEY (follower_id)
        REFERENCES users (id) on delete cascade
);