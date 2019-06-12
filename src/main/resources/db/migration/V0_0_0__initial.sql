drop table if exists character;

create table character (
	id VARCHAR(255) not null primary key ,
	firstName VARCHAR(255) not null,
	lastName VARCHAR(255) not null,
	picture VARCHAR(255) not null,
	age int not null
);

drop table if exists phrase;

create table phrase (
    id VARCHAR(255) not null primary key,
    character VARCHAR(255) not null references character(id),
    phrase VARCHAR(511) not null
);

insert into character values ('59edee68706374dfa957842f', 'Homer', 'Simpson', 'http://www.trbimg.com/img-573a089a/turbine/ct-homer-simpson-live-pizza-debate-met-0517-20160516', 43);
insert into character values ('59edee689509e51682ff8e02', 'Marge', 'Simpson', 'https://vignette.wikia.nocookie.net/simpsons/images/8/87/Marge_Simpson_2.png/revision/latest?cb=20150131104556', 40);
insert into character values ('59edee68eff3f80413c136f8', 'Lisa', 'Simpson', 'https://vignette.wikia.nocookie.net/simpsons/images/1/12/Lisa_Simpson-0.png/revision/latest?cb=20161027220133', 10);
insert into character values ('59edee683406c7834ee7cdd8', 'Bart', 'Simpson', 'https://vignette.wikia.nocookie.net/simpsons/images/a/ab/BartSimpson.jpg/revision/latest?cb=20141101133153', 12);
insert into character values ('59edee68b4b101bef064bf11', 'Hugo', 'Simpson', 'https://static.simpsonswiki.com/images/thumb/1/1a/Hugo_Simpson.png/200px-Hugo_Simpson.png', 12);
insert into character values ('59edee68874eb2fa23678344', 'Ned', 'Flanders', 'https://vignette.wikia.nocookie.net/simpsons/images/8/84/Ned_Flanders.png/revision/latest?cb=20100513160156', 50);
insert into character values ('59edee68efd448eefb265420', 'Rod', 'Flanders', 'https://vignette.wikia.nocookie.net/simpsons/images/e/e6/Rod_Flanders2.png/revision/latest?cb=20140817110904', 13);
insert into character values ('59edee68ea392a3947485d41', 'Todd', 'Flanders', 'https://vignette.wikia.nocookie.net/simpsons/images/1/18/Todd_Flanders.png/revision/latest?cb=20131223200228', 12);
insert into character values ('59edee682c7acf7bfac7e66b', 'Maude', 'Flanders', 'https://vignette.wikia.nocookie.net/simpsons/images/9/95/Maude_Flanders.png/revision/latest/scale-to-width-down/286?cb=20170923223722', 49);

insert into phrase values ('59edff64d9be8f7aa11e0c44', '59edee68706374dfa957842f','Wait a minute. Bart''s teacher is named ''Krabappel''? Oh, I’ve been calling her ''Crandall.'' Why didn''t anyone tell me? Ohhh, I''ve been making an idiot out of myself!');
insert into phrase values ('59edff6492d619b4a933a56b', '59edee68706374dfa957842f','Now we play the waiting game…Ahh, the waiting game sucks. Let\’s play Hungry Hungry Hippos!');
insert into phrase values ('59edff6477ac8539e526682b', '59edee689509e51682ff8e02','Go out on a Tuesday? Who am I, Charlie Sheen?');
insert into phrase values ('59edff647cf388e225bc5f4e', '59edee689509e51682ff8e02','I brought you a tuna sandwich. They say it''s brain food. I guess because there''s so much dolphin in it, and you know how smart they are.');
insert into phrase values ('59edff64ac4dccc4b0e35784', '59edee68eff3f80413c136f8','I''d be mortified if someone ever made a lousy product with the Simpson name on it.');
insert into phrase values ('59edff6419f9d6df24d593fe', '59edee68eff3f80413c136f8','You monster! You monster!');
insert into phrase values ('59edff6403042a54f6038044', '59edee683406c7834ee7cdd8','There''s only one thing to do at a moment like this: strut!');
insert into phrase values ('59edff643d4737e47c71835c', '59edee683406c7834ee7cdd8','Aren''t we forgetting the true meaning of Christmas: the birth of Santa.');
insert into phrase values ('59edff641b4c1f62aebe1e4d', '59edee68b4b101bef064bf11','I made a Pigeon-rat.');
insert into phrase values ('59edff643fbeca90867aa34d', '59edee68b4b101bef064bf11','Am I? Well, perhaps we''re all a little crazy. I know I am. I went mad after they tore us apart, but I''ll be sane… once I sew us back together.');
insert into phrase values ('59edff6494f9aef192ef4813', '59edee68874eb2fa23678344','Diddly');
insert into phrase values ('59edff6458b6a68631660120', '59edee68efd448eefb265420','We just move one space at a time. It''s less fun that way.');
insert into phrase values ('59edff646c740f1218a30a06', '59edee68efd448eefb265420','Thank you, door!');
insert into phrase values ('59edff644abadfc108cac2a6', '59edee68ea392a3947485d41','Daddy says dice are wicked.');
insert into phrase values ('59edff64b5988eeae9953b59', '59edee68ea392a3947485d41','Thank you, door!');
insert into phrase values ('59edff64fd7790417d74b3a1', '59edee682c7acf7bfac7e66b','Oh, I don''t care for the speed, but I can''t get enough of that safety gear - helmets, roll bars, caution flags...');

