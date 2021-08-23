drop if exists games;
CREATE TABLE games
(
    section_id        		SERIAL PRIMARY KEY,
    section_name        		varchar(80)   NOT NULL,
    section_description 		varchar(1024) NOT NULL,
    section_players_limit      	integer       NOT NULL
);
