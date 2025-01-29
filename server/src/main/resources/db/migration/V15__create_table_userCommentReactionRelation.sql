CREATE TABLE IF NOT EXISTS user_comment_reaction_relation
(
id INT AUTO_INCREMENT PRIMARY KEY,
user_id INT NOT NULL,
comment_id INT NOT NULL,
reaction_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES users(id),
FOREIGN KEY (comment_id) REFERENCES comments(id),
FOREIGN KEY (reaction_id) REFERENCES reactions(id)
)