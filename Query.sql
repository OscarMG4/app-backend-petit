select u.id_user, u.names, u.last_names, a.id_account, a.email , a.pass, tc.id_account_type, tc.account_type from accounts as a
inner join users as u on a.id_user like u.id_user
inner join accounts_types as tc on a.id_account like tc.id_account_type 
where a.id_user like 1; 


select u.id_user, u.names, u.last_names, q.id_quote , q.date_issued, q.date_attention, st.id_service_type, st.service_type, q.price, s.id_state, s.state from quotes as q
inner join services_types as st on q.id_service_type like st.id_service_type
inner join users as u on q.id_user like u.id_user
inner join states as s on q.id_state like s.id_state 
where q.id_user like 1; 

select p.id_pet, p.name, pt.id_pet_type, pt.pet_type, p.age, p.race, p.sex from pets as p
inner join pets_types as pt on p.id_pet_type like pt.id_pet_type 
where pt.id_pet_type like 1; 

select p.id_pet, p.name, pt.id_pet_type, pt.pet_type, p.age, p.race, p.sex from pets as p
inner join pets_types as pt on p.id_pet_type like pt.id_pet_type 
where pt.pet_type like 'Perro'; 


select u.id_user, u.names, u.last_names, a.id_adoption, a.description, p.id_pet, p.name, s.id_state, s.state  from adoptions as a
inner join pets as p on a.id_pet like p.id_pet
inner join states as s on a.id_state like s.id_state
inner join users as u on a.id_user like u.id_user
where a.id_user like 1; 

select u.id_user, u.names, u.last_names, u.dni, u.phone, u.photo, a.id_account, a.email from users as u
inner join accounts as a on a.id_user like u.id_user 
where a.email like 'oscar@gmail.com'; 
