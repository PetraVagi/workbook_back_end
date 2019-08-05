INSERT INTO public.question (questionid, question_text, room) VALUES (2, 'What is casting? What is the difference between up vs downcasting?', 'OOP');
INSERT INTO public.answer (answerid, answer_text, right_answer, question_questionid) VALUES (3, 'Casting means taking an Object of one type and turning it into a differentObject type. With downcasting, we are turning the Object into a subtype,and with upcasting we are turning it into a supertype. Upcasting is always allowed,but downcasting involves a type check that can throw a ClassCastException.', true, 2);
INSERT INTO public.tag (tagid, name) VALUES (1, 'Programming paradigms');
INSERT INTO public.question_tag (question_id, tag_id) VALUES (2, 1);
INSERT INTO public.rating (ratingid, rated_as_known, question_id) VALUES (4, false, 2);
