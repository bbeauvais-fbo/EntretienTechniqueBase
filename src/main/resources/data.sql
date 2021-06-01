INSERT INTO localisation (libelle) values ('Nantes'), -- 1
	('La Roche-Sur-Yon'), -- 2
	('Paris'), -- 3
	('Marseille'), -- 4
	('Lille'), -- 5
	('Toulouse'); -- 6

	insert into trajet (intitule, moment_depart, moment_arrivee) values
		('Tour de France 2021', NOW(), null), -- 1
		('Livraison Hebdomadaire Nantes - Paris', TIMESTAMPADD(WEEK, -1, NOW()), TIMESTAMPADD(HOUR, 4, TIMESTAMPADD(WEEK, -1, NOW()))), -- 2
		('Livraison Hebdomadaire Nantes - Paris', NOW(), NULL), -- 3
		('Livraison Hebdomadaire Nantes - Paris', TIMESTAMPADD(WEEK, 1, NOW()), NULL), -- 4
		('Tour de France 2020', TIMESTAMPADD(YEAR, -1, NOW()), TIMESTAMPADD(DAY, 7, TIMESTAMPADD(YEAR, -1, NOW()))), --5
		('Livraison de Bouillabaisse', TIMESTAMPADD(HOUR, -1, NOW()), null), -- 6
		('Livraison de Mogette', TIMESTAMPADD(DAY, -1, NOW()), null), --7
		('Livraison de la Tour Eiffel', TIMESTAMPADD(HOUR, -5, NOW()), NOW()); -- 8
	
	
	insert into etape (ordre, id_localisation, id_trajet) values
		(1, 1, 1),
		(2, 5, 1),
		(3, 3, 1),
		(4, 4, 1),
		(5, 6, 1),
		(6, 2, 1),
		(1, 1, 2),
		(2, 3, 2),
		(1, 1, 3),
		(2, 3, 3),
		(1, 1, 4),
		(2, 3, 4),
		(1, 1, 5),
		(2, 5, 5),
		(3, 3, 5),
		(4, 4, 5),
		(5, 6, 5),
		(6, 2, 5),
		(1, 4, 6),
		(2, 6, 6),
		(3, 3, 6),
		(4, 5, 6),
		(1, 2, 7),
		(2, 1, 7),
		(3, 3, 7),
		(1, 1, 8),
		(2, 3, 8);
		
	INSERT INTO distance (kilometrage, id_depart, id_arrivee) values
	(150, 1, 2),
	(350, 1, 3),
	(742.6, 1, 4),
	(567, 1, 5),
	(478, 1, 6),
	(168, 2, 1),
	(517, 2, 3),
	(634, 2, 4),
	(765, 2, 5),
	(567, 2, 6),
	(145, 3, 1),
	(786, 3, 2),
	(432, 3, 4),
	(324, 3, 5),
	(654, 3, 6),
	(213, 4, 1),
	(345, 4, 2),
	(523, 4, 3),
	(234, 4, 5),
	(643, 4, 6),
	(98, 5, 1),
	(156, 5, 2),
	(763, 5, 3),
	(245, 5, 4),
	(723, 5, 6),
	(456, 6, 1),
	(435, 6, 2),
	(489, 6, 3),
	(623, 6, 4),
	(634, 6, 5);
	