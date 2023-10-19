DROP TABLE IF EXISTS user_answer;
DROP TABLE IF EXISTS answer_option;
DROP TABLE IF EXISTS poll_question;

CREATE TABLE poll_question (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    question_title VARCHAR(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE answer_option (
    answer_option_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    answer_option_1 VARCHAR(300) NOT NULL,
    answer_option_2 VARCHAR(300) NOT NULL,
    answer_option_3 VARCHAR(300) NOT NULL,
    answer_option_4 VARCHAR(300) NOT NULL,
    question_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (answer_option_id),
    FOREIGN KEY (question_id) REFERENCES poll_question (id)
);

CREATE TABLE user_answer (
    answer_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    question_id INT UNSIGNED NOT NULL,
    answer_option_id INT UNSIGNED NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    selected_answer int(11) NOT NULL,
    PRIMARY KEY (answer_id),
    FOREIGN KEY (question_id) REFERENCES poll_question (id),
    FOREIGN KEY (answer_option_id) REFERENCES answer_option (answer_option_id)
);
