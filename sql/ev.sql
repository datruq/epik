CREATE TABLE public.ev (
	id bigserial NOT NULL,
	battery_capacity int4 NULL,
	model int4 NULL,
	CONSTRAINT ev_pkey PRIMARY KEY (id)
);

INSERT INTO public.ev (id,battery_capacity,model) VALUES 
(1,1,1)
,(2,0,1)
,(3,0,0)
,(4,2,2)
;
