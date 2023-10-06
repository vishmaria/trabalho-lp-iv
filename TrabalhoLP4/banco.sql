create table comodo (
	id_c serial primary key,
	nome varchar
);
create table aparelho (
	id_a serial primary key,
	comodo int references comodo (id_c),
	nome varchar
);
select * from comodo
select * from aparelho

update aparelho set nome = 'lampada' where id_a = 1