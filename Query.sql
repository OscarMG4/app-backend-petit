select u.id_user, a.id_account, a.email , a.pass from accounts as a
inner join users as u on a.id_user like u.id_user
where a.id_user like 1; 

select u.id_user, q.id_quote , q.date_issued, q.date_attention, q.type_service, q.price, s.id_state, s.name from quotes as q
inner join users as u on q.id_user like u.id_user
inner join states as s on q.id_state like s.id_state 
where q.id_user like 1; 

select u.id_user, a.id_adoption, a.description, p.id_pet, s.id_state from adoptions as a
inner join pets as p on a.id_pet like p.id_pet 
inner join states as s on a.id_state like s.id_state
inner join users as u on a.id_user like u.id_user
where a.id_user like 1; 

select * from states;