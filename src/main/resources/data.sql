INSERT INTO recipe (title, description, prep_time_minutes, cook_time_minutes, servings, difficulty, category, image_url)
VALUES
-- 1
('Spaghetti Carbonara',
'A classic Italian pasta dish made with just a few simple ingredients, yet incredibly creamy.
First, fry bacon in a pan until crispy and set aside. In a bowl, whisk together eggs and freshly grated Parmesan, season generously with pepper.
In a large pot, cook the spaghetti in salted water until al dente.
Once done, drain and immediately add them to the hot pan with the bacon.
Remove the pan from heat and quickly stir in the egg-Parmesan mixture – the residual heat creates a creamy sauce without scrambling the eggs.
Finally, serve with extra Parmesan and pepper.',
10, 15, 2, 'MEDIUM', 'Pasta', '/assets/carbonara.jpg'),

-- 2
('Vegetable Stir-Fry with Soy Sauce and Sesame',
'A quick and colorful vegetable stir-fry – perfect when you want something healthy and easy.
Step 1: Cut bell pepper, zucchini, and carrots into bite-sized pieces.
Step 2: Heat some oil in a large pan, sauté onion and garlic until translucent.
Step 3: Add the prepared vegetables and stir-fry for a few minutes until lightly browned.
Step 4: Deglaze with soy sauce and let it reduce briefly.
Step 5: Sprinkle with sesame seeds and serve with rice or noodles.
Tip: Add fresh ginger or chili for extra flavor.',
10, 10, 2, 'EASY', 'Vegetarian', '/assets/gemuesepfanne.jpg'),

-- 3
('Tomato Soup with Basil',
'This classic tomato soup is wonderfully creamy and tastes just like in Italy.
Step 1: Finely chop onion and garlic, sauté in olive oil until translucent.
Step 2: Add fresh or canned tomatoes, roast briefly, then pour in vegetable broth.
Step 3: Simmer for about 20 minutes until the tomatoes are soft.
Step 4: Blend the soup and season with salt, pepper, and fresh basil.
Step 5: Finish with a splash of cream or crème fraîche and garnish with basil leaves.',
15, 25, 4, 'EASY', 'Soups', '/assets/tomatensuppe.jpg'),

-- 4
('Beef Roulades with Red Cabbage and Dumplings',
'A traditional Sunday dish that becomes a real treat with a bit of patience.
Step 1: Lay out the beef slices, spread with mustard, and top with bacon, onions, and pickles.
Step 2: Roll tightly and secure with kitchen twine or toothpicks.
Step 3: Brown all over in a roasting pan, then add broth and simmer on low heat for about 2 hours.
Step 4: Meanwhile, prepare red cabbage and dumplings.
Step 5: Season the sauce, plate the roulades, and serve with the sides. A classic that never fails.',
40, 120, 4, 'HARD', 'Traditional', '/assets/rouladen.jpg'),

-- 5
('Chicken Curry with Coconut Milk',
'A creamy curry with an Asian twist – flavorful, aromatic, and still mild enough for the whole family.
Step 1: Finely chop onions and ginger, sauté in oil until translucent.
Step 2: Add curry paste and fry briefly until fragrant.
Step 3: Add chicken pieces and brown on all sides.
Step 4: Pour in coconut milk, add sliced bell pepper, and simmer for 15–20 minutes.
Step 5: Season with lime juice, salt, and fresh coriander. Perfect with basmati rice.',
20, 25, 3, 'MEDIUM', 'Asian', '/assets/haehnchen-curry.jpg'),

-- 6
('Roasted Vegetables with Feta and Rosemary',
'Colorful oven-roasted vegetables – the perfect mix of simplicity and flavor.
Step 1: Preheat the oven to 200°C (400°F).
Step 2: Cut bell peppers, zucchini, sweet potatoes, and red onions into chunks.
Step 3: Toss with olive oil, salt, pepper, and fresh rosemary, then spread on a baking sheet.
Step 4: Roast for about 30 minutes until tender and lightly caramelized.
Step 5: Crumble feta over the top and bake briefly. Serve warm – great with quark or bread.',
15, 30, 2, 'EASY', 'Vegetarian', '/assets/ofengemuese.jpg'),

-- 7
('Chocolate Brownies with Sea Salt',
'These brownies are slightly crispy on the outside and deliciously fudgy on the inside.
Step 1: Melt chocolate and butter in a double boiler.
Step 2: Stir in sugar and eggs until creamy.
Step 3: Add flour and mix just until combined to keep the texture fudgy.
Step 4: Pour into a greased pan, sprinkle with sea salt, and bake for 25 minutes.
Step 5: Let cool, then cut into squares. Perfect with vanilla ice cream or coffee.',
15, 25, 8, 'MEDIUM', 'Dessert', '/assets/brownies.jpg'),

-- 8
('Salmon Fillet with Lemon-Dill Sauce',
'A light, aromatic fish dish – quick to make and always a highlight.
Step 1: Pat the salmon dry, season with salt and pepper.
Step 2: Fry in butter on both sides until golden brown and just pink inside.
Step 3: For the sauce, bring cream and lemon juice to a boil, stir in dill, and season to taste.
Step 4: Pour the sauce over the salmon and serve with rice or potatoes.
Step 5: Garnish with lemon zest and fresh dill.',
10, 20, 2, 'MEDIUM', 'Fish', '/assets/lachs.jpg');


INSERT INTO recipe_ingredient (recipe_id, ingredient) VALUES
-- Carbonara
(1, 'Spaghetti'),
(1, 'Bacon'),
(1, 'Eggs'),
(1, 'Parmesan'),
(1, 'Black pepper'),
(1, 'Salt'),

-- Vegetable Stir-Fry
(2, 'Bell pepper'),
(2, 'Zucchini'),
(2, 'Carrots'),
(2, 'Soy sauce'),
(2, 'Sesame seeds'),
(2, 'Onion'),
(2, 'Garlic'),

-- Tomato Soup
(3, 'Tomatoes'),
(3, 'Onion'),
(3, 'Garlic'),
(3, 'Basil'),
(3, 'Olive oil'),
(3, 'Vegetable broth'),

-- Beef Roulades
(4, 'Beef'),
(4, 'Bacon'),
(4, 'Mustard'),
(4, 'Pickles'),
(4, 'Onions'),
(4, 'Red cabbage'),
(4, 'Potatoes'),

-- Chicken Curry
(5, 'Chicken breast'),
(5, 'Bell pepper'),
(5, 'Coconut milk'),
(5, 'Curry paste'),
(5, 'Ginger'),
(5, 'Lime juice'),
(5, 'Coriander'),

-- Roasted Vegetables
(6, 'Bell pepper'),
(6, 'Zucchini'),
(6, 'Sweet potato'),
(6, 'Red onion'),
(6, 'Feta'),
(6, 'Olive oil'),
(6, 'Rosemary'),

-- Brownies
(7, 'Dark chocolate'),
(7, 'Butter'),
(7, 'Sugar'),
(7, 'Flour'),
(7, 'Eggs'),
(7, 'Sea salt'),

-- Salmon with Lemon-Dill Sauce
(8, 'Salmon fillet'),
(8, 'Cream'),
(8, 'Lemon'),
(8, 'Dill'),
(8, 'Butter'),
(8, 'Salt'),
(8, 'Pepper');
