DROP database IF EXISTS worldcup;
create database worldcup;




															-- Query : 1 = Design Table




CREATE TABLE worldcup.India (
  playerId int NOT NULL,
  playerType varchar(50) NOT NULL,
  country varchar(50) NOT NULL,
  Run_2007 int ,
  wicket_2007 int ,
  Run_2011 int ,
  wicket_2011 int ,
  PRIMARY KEY (playerId)
);

CREATE TABLE worldcup.Pakistan (
  playerId int NOT NULL,
  playerType varchar(50) NOT NULL,
  country varchar(50) NOT NULL,
  Run_2007 int ,
  wicket_2007 int ,
  Run_2011 int ,
  wicket_2011 int ,
  PRIMARY KEY (playerId)
);

insert into worldcup.India values
(101,'Batsman','India',99,0,44,0),
(102,'Batsman','India',70,1,34,0),
(103,'Batsman','India',60,0,99,0),
(104,'Bowler','India',30,2,10,3),
(105,'Bowler','India',10,1,15,2),
(106,'Batsman','India',0,0,44,0),
(107,'Batsman','India',30,1,34,0),
(108,'Batsman','India',10,0,99,0),
(109,'Bowler','India',0,2,10,0),
(110,'Bowler','India',0,1,15,0),
(111,'Bowler','India',0,1,15,0);

Alter Table worldcup.india add column Avg_run int ;
Update worldcup.india set worldcup.india.Avg_run= (worldcup.india.Run_2007+worldcup.india.Run_2011)/2;
Alter Table worldcup.india add column Avg_Wicket int ;
Update worldcup.india set worldcup.india.Avg_Wicket= (worldcup.india.Wicket_2007+worldcup.india.Wicket_2011)/2;
select * from worldcup.India;

insert into worldcup.Pakistan values
(201,'Batsman','pakistan',40,0,60,0),
(202,'Bowler','pakistan',10,2,5,0),
(203,'Bowler','pakistan',20,3,7,0),
(204,'Bowler','pakistan',10,0,1,0),
(205,'Bowler','pakistan',15,1,15,2),
(206,'Batsman','pakistan',40,0,40,0),
(207,'Batsman','pakistan',40,0,35,0),
(208,'Batsman','pakistan',40,0,10,0),
(209,'Batsman','pakistan',40,0,6,0),
(210,'Bowler','pakistan',1,1,12,2),
(211,'Bowler','pakistan',15,1,45,2);

Alter Table worldcup.Pakistan add column Avg_run int ;
Update worldcup.Pakistan set worldcup.Pakistan.Avg_run= (worldcup.Pakistan.Run_2007+worldcup.Pakistan.Run_2011)/2;
Alter Table worldcup.Pakistan add column Avg_Wicket int ;
Update worldcup.Pakistan set worldcup.Pakistan.Avg_Wicket= (worldcup.Pakistan.Wicket_2007+worldcup.Pakistan.Wicket_2011)/2;
select * from worldcup.Pakistan;




														-- Query 2: Top 5 batsman


                                                        
                                                        
select * from (
	select * from worldcup.India where playerType='Batsman' 
    union all 
    select * from worldcup.Pakistan where playerType='Batsman') 
    as RUN order by Avg_run desc limit 5;




																			
															-- Query 3: Top 5 Bowler





select * from (
	select * from worldcup.India where playerType='Bowler' 
    union all 
    select * from worldcup.Pakistan where playerType='Bowler') 
    as RUN order by Avg_Wicket desc limit 5;
    


								
													-- Query 4: Average score of each team till date




select country,sum(Avg_run) as Run from worldcup.India union select country, sum(Avg_run) as run from worldcup.Pakistan ;
    






											-- Query 6: Write a procedure which take input as a Country and 
											-- 			return maximum run scored by the team till date







use Worldcup;
DROP procedure IF EXISTS ScoreofTeam;
DELIMITER $$
CREATE PROCEDURE ScoreofTeam (country VARCHAR(50), OUT score INT)
BEGIN
	case when country='India' then
		select Max(run) into score  from 
		(select sum(Run_2007) as Run from worldcup.India 
		union 
		select sum(Run_2011) as run from worldcup.India) as T;
	else
		select Max(run) into score from 
        (select sum(Run_2007) as Run from worldcup.Pakistan 
        union 
        select sum(Run_2011) as run from worldcup.Pakistan) as T;
	end case;
END$$
DELIMITER ;

CALL ScoreofTeam('India',@India_score);
SELECT @India_score as Inida_MAX_RUN_TILL_DATE;

CALL ScoreofTeam('Pakistan',@Pakistan_score);
SELECT @Pakistan_score as Pakistan_MAX_RUN_TILL_DATE;





								-- Query 5: increase 10 run of each player whose team score is 
										-- less than average computed in above query (Query : 6)
                                
                                -- Query 6: Above (I used output of query 6)




Update worldcup.India 
set worldcup.India.Run_2007= worldcup.India.Run_2007+10 where @Pakistan_score > @India_score and @Pakistan_score = (select * from (select sum(Run_2007) from worldcup.India) as Tu); 
Update worldcup.India
set worldcup.India.Run_2011= worldcup.India.Run_2011+10 where @Pakistan_score > @India_score and @Pakistan_score = (select * from (select sum(Run_2011) from worldcup.India) as Tu);  
ALTER TABLE worldcup.India
DROP COLUMN Avg_run , 
Drop Column Avg_wicket;

Update worldcup.Pakistan 
set worldcup.Pakistan.Run_2007= worldcup.Pakistan.Run_2007+10 where @Pakistan_score < @India_score and @Pakistan_score = (select * from (select sum(Run_2007) from worldcup.Pakistan) as Tu); 
Update worldcup.Pakistan
set worldcup.Pakistan.Run_2011= worldcup.Pakistan.Run_2011+10 where @Pakistan_score < @India_score and @Pakistan_score = (select * from (select sum(Run_2007) from worldcup.Pakistan) as Tu);  
ALTER TABLE worldcup.Pakistan
DROP COLUMN Avg_run , 
Drop Column Avg_wicket;


select * from worldcup.India ;
select * from worldcup.Pakistan;





