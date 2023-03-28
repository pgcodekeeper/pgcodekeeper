-----------------------------------------------------------------------
-- SELECT https://msdn.microsoft.com/en-us/library/ms187731.aspx

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using SELECT to retrieve rows and columns


-- Using MATCH in WHERE

--simple match
SELECT Person2.name AS FriendName
FROM Person Person1, friend, Person Person2
WHERE MATCH(Person1-(friend)->Person2)
AND Person1.name = 'Alice';
GO

-- simple match
SELECT Person2.name AS FriendName
FROM Person Person1, friend, Person Person2 
WHERE MATCH(Person2<-(friend)-Person1);
GO

-- Find 2 people who are both friends with same person
SELECT Person3.name AS FriendName 
FROM Person Person1, friend, Person Person2, friend friend2, Person Person3
WHERE MATCH(Person1-(friend)->Person2-(friend2)->Person3)
AND Person1.name = 'Alice';
GO

-- Find 2 people who are both friends with same person
SELECT Person1.name AS Friend1, Person2.name AS Friend2
FROM Person Person1, friend friend1, Person Person2, 
friend friend2, Person Person0
WHERE MATCH(Person1-(friend1)->Person0<-(friend2)-Person2);
GO

-- this pattern can also be expressed as below
SELECT Person1.name AS Friend1, Person2.name AS Friend2
FROM Person Person1, friend friend1, Person Person2, 
friend friend2, Person Person0
WHERE MATCH(Person1-(friend1)->Person0 AND Person2-(friend2)->Person0);
GO

--SHORTEST_PATH 
SELECT
Person1.name AS PersonName,
Person2.name AS Friends,
Person2.name AS LastNode
FROM
Person AS Person1,
friendOf AS fo,
Person AS Person2
WHERE MATCH(SHORTEST_PATH(Person1(-(fo)->Person2)+))
AND Person1.name = 'Jacob'
GO

--SHORTEST_PATH
SELECT
Person1.name AS PersonName,
Person2.name AS Friends
FROM
Person AS Person1,
friendOf AS fo,
Person AS Person2
WHERE MATCH(SHORTEST_PATH(Person1(-(fo)->Person2){1,3}))
AND Person1.name = 'Jacob'
GO

--SHORTEST_PATH
SELECT
Person1.name AS PersonName,
Person2.name AS Friends,
Restaurant.name
FROM
Person AS Person1,
friendOf AS fo,
Person AS Person2,
likes,
Restaurant
WHERE MATCH(SHORTEST_PATH(Person1(-(fo)->Person2){1,3}) AND LAST_NODE(Person2)-(likes)->Restaurant )
AND Person1.name = 'Jacob'
AND Restaurant.name = 'Ginger and Spice'
GO

--double MATCH
SELECT Restaurant.name
FROM Person person1, Person person2, likes, friendOf, Restaurant,  riend friend2, Person Person0
WHERE MATCH(person1-(friendOf)->person2-(likes)->Restaurant) AND person1.name='John' AND MATCH(person2-(friend2)->person2)
AND person1.name='John';
GO

--MATCH after search condition
SELECT Restaurant.name
FROM Person person1, Person person2, likes, friendOf, Restaurant,  riend friend2, Person Person0
WHERE person1.name='John' AND
MATCH(person1-(friendOf)->person2-(likes)->Restaurant);
GO

--double LAST_NODE
SELECT
Person1.name AS PersonName
FROM
Person person1, Person person2
WHERE MATCH(LAST_NODE(Person2) = LAST_NODE(Restaurant));
GO

SELECT 1 FROM T WHERE
MATCH(SHORTEST_PATH ( P1(-(fo)->P2){1,3} ) AND LAST_NODE (P2)-(likes)->R)
GO

SELECT 1 FROM T WHERE
MATCH(VR-(B1)->Q<-(B2)-VB AND VG-(B3)->Q);
GO

SELECT 1 FROM T WHERE
MATCH (c2<-(ln2)-r2<-(l2)-p1-(friendOf)->p2-(l1)->r1-(ln1)->c1)
GO

SELECT 1 FROM T WHERE
MATCH(SHORTEST_PATH(P1(-(fo)->P2)+) AND SHORTEST_PATH(LAST_NODE(P2)(-(so)->P3)+))
GO

SELECT 1 FROM T WHERE
MATCH(SHORTEST_PATH(P1(-(so)->P2)+) AND SHORTEST_PATH(LAST_NODE(P2)(<-(fo)-P3)+) AND LAST_NODE(P3)-(l)->r)
GO

SELECT 1 FROM T WHERE
MATCH(LAST_NODE(P3) = LAST_NODE(P2))
GO
