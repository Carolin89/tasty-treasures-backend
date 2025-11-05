INSERT INTO recipe (title, description, prep_time_minutes, cook_time_minutes, servings, difficulty, category, image_url)
VALUES
-- 1
('Spaghetti Carbonara',
'Ein klassisches italienisches Pastagericht, das mit wenigen Zutaten auskommt und trotzdem unglaublich cremig ist.
Zuerst Speck in einer Pfanne knusprig anbraten und beiseitestellen. In einer Schüssel Eier mit frisch geriebenem Parmesan verrühren und kräftig mit Pfeffer würzen.
In einem großen Topf die Spaghetti in Salzwasser al dente kochen.
Sobald die Nudeln fertig sind, abgießen und sofort in die heiße Pfanne mit dem Speck geben.
Die Pfanne vom Herd nehmen und die Eier-Parmesan-Mischung unterheben – durch die Resthitze entsteht eine cremige Sauce ohne zu stocken.
Zum Schluss mit etwas zusätzlichem Parmesan und Pfeffer servieren.',
10, 15, 2, 'MEDIUM', 'Pasta', '/assets/carbonara.jpg'),

-- 2
('Gemüsepfanne mit Sojasauce und Sesam',
'Eine schnelle, bunte Gemüsepfanne – perfekt, wenn es gesund und einfach sein soll.
Schritt 1: Paprika, Zucchini und Karotten in mundgerechte Stücke schneiden.
Schritt 2: Etwas Öl in einer großen Pfanne erhitzen, Zwiebel und Knoblauch darin glasig anbraten.
Schritt 3: Das vorbereitete Gemüse hinzugeben und einige Minuten unter Rühren anbraten, bis es leicht gebräunt ist.
Schritt 4: Mit Sojasauce ablöschen und kurz einkochen lassen.
Schritt 5: Mit Sesam bestreuen und nach Belieben mit Reis oder Nudeln servieren.
Tipp: Für mehr Würze kann man auch etwas frischen Ingwer oder Chili hinzufügen.',
10, 10, 2, 'EASY', 'Vegetarisch', '/assets/gemuesepfanne.jpg'),

-- 3
('Tomatensuppe mit Basilikum',
'Diese klassische Tomatensuppe ist wunderbar cremig und schmeckt wie in Italien.
Schritt 1: Zwiebel und Knoblauch fein hacken und in Olivenöl glasig dünsten.
Schritt 2: Frische oder gehackte Tomaten hinzufügen, kurz anrösten und dann mit Gemüsebrühe ablöschen.
Schritt 3: 20 Minuten köcheln lassen, bis die Tomaten weich sind.
Schritt 4: Suppe pürieren und mit Salz, Pfeffer und frischem Basilikum abschmecken.
Schritt 5: Mit einem Schuss Sahne oder Crème fraîche verfeinern und mit Basilikumblättern garnieren.',
15, 25, 4, 'EASY', 'Suppen', '/assets/tomatensuppe.jpg'),

-- 4
('Rinderrouladen mit Rotkohl und Klößen',
'Ein traditionelles Festtagsgericht, das mit etwas Geduld zum echten Genuss wird.
Schritt 1: Rouladen flach auslegen, mit Senf bestreichen und mit Speck, Zwiebeln und Essiggurken belegen.
Schritt 2: Eng einrollen und mit Küchengarn oder Zahnstochern fixieren.
Schritt 3: In einem Bräter von allen Seiten anbraten, dann mit Brühe aufgießen und bei niedriger Hitze etwa 2 Stunden schmoren.
Schritt 4: Währenddessen Rotkohl und Klöße zubereiten.
Schritt 5: Sauce abschmecken, Rouladen anrichten und mit Beilagen servieren. Ein Klassiker, der immer gelingt.',
40, 120, 4, 'HARD', 'Hausmannskost', '/assets/rouladen.jpg'),

-- 5
('Hähnchen-Curry mit Kokosmilch',
'Ein cremiges Curry mit asiatischem Touch – würzig, aromatisch und trotzdem mild genug für die ganze Familie.
Schritt 1: Zwiebeln und Ingwer fein hacken und in Öl glasig anbraten.
Schritt 2: Currypaste hinzufügen und kurz anrösten, bis sie duftet.
Schritt 3: Hähnchenstücke dazugeben und rundherum anbraten.
Schritt 4: Mit Kokosmilch ablöschen, Paprikastreifen hinzufügen und 15–20 Minuten köcheln lassen.
Schritt 5: Mit Limettensaft, Salz und frischem Koriander abschmecken. Dazu passt perfekt Basmatireis.',
20, 25, 3, 'MEDIUM', 'Asiatisch', '/assets/haehnchen-curry.jpg'),

-- 6
('Ofengemüse mit Feta und Rosmarin',
'Buntes Ofengemüse ist die perfekte Kombination aus Einfachheit und Geschmack.
Schritt 1: Backofen auf 200 °C vorheizen.
Schritt 2: Paprika, Zucchini, Süßkartoffeln und rote Zwiebeln in Stücke schneiden.
Schritt 3: Mit Olivenöl, Salz, Pfeffer und frischem Rosmarin vermengen und auf einem Backblech verteilen.
Schritt 4: Etwa 30 Minuten rösten, bis das Gemüse weich und leicht karamellisiert ist.
Schritt 5: Feta darüber bröseln und kurz mitbacken. Warm servieren – ideal mit Quark oder Brot.',
15, 30, 2, 'EASY', 'Vegetarisch', '/assets/ofengemuese.jpg'),

-- 7
('Schoko-Brownies mit Meersalz',
'Diese Brownies sind außen leicht knusprig und innen herrlich saftig.
Schritt 1: Schokolade und Butter im Wasserbad schmelzen.
Schritt 2: Zucker und Eier unterrühren, bis die Masse cremig ist.
Schritt 3: Mehl hinzufügen und nur kurz verrühren, damit der Teig fudgy bleibt.
Schritt 4: In eine gefettete Form füllen, mit einer Prise Meersalz bestreuen und 25 Minuten backen.
Schritt 5: Abkühlen lassen und in Stücke schneiden. Perfekt zu Vanilleeis oder Kaffee.',
15, 25, 8, 'MEDIUM', 'Dessert', '/assets/brownies.jpg'),

-- 8
('Lachsfilet mit Zitronen-Dill-Sauce',
'Ein leichtes, aromatisches Fischgericht – schnell gemacht und immer ein Highlight.
Schritt 1: Lachsfilets trocken tupfen, salzen und pfeffern.
Schritt 2: In Butter von beiden Seiten anbraten, bis sie goldbraun und innen zart rosa sind.
Schritt 3: Für die Sauce Sahne mit Zitronensaft aufkochen, Dill einrühren und abschmecken.
Schritt 4: Sauce über den Lachs geben und mit Reis oder Kartoffeln servieren.
Schritt 5: Mit etwas Zitronenschale und Dillspitzen garnieren.',
10, 20, 2, 'MEDIUM', 'Fisch', '/assets/lachs.jpg');



INSERT INTO recipe_ingredient (recipe_id, ingredient) VALUES
-- Carbonara
(1, 'Spaghetti'),
(1, 'Speck'),
(1, 'Eier'),
(1, 'Parmesan'),
(1, 'Schwarzer Pfeffer'),
(1, 'Salz'),

-- Gemüsepfanne
(2, 'Paprika'),
(2, 'Zucchini'),
(2, 'Karotten'),
(2, 'Sojasauce'),
(2, 'Sesam'),
(2, 'Zwiebel'),
(2, 'Knoblauch'),

-- Tomatensuppe
(3, 'Tomaten'),
(3, 'Zwiebel'),
(3, 'Knoblauch'),
(3, 'Basilikum'),
(3, 'Olivenöl'),
(3, 'Gemüsebrühe'),

-- Rinderrouladen
(4, 'Rindfleisch'),
(4, 'Speck'),
(4, 'Senf'),
(4, 'Essiggurken'),
(4, 'Zwiebeln'),
(4, 'Rotkohl'),
(4, 'Kartoffeln'),

-- Hähnchen-Curry
(5, 'Hähnchenbrust'),
(5, 'Paprika'),
(5, 'Kokosmilch'),
(5, 'Currypaste'),
(5, 'Ingwer'),
(5, 'Limettensaft'),
(5, 'Koriander'),

-- Ofengemüse
(6, 'Paprika'),
(6, 'Zucchini'),
(6, 'Süßkartoffel'),
(6, 'Rote Zwiebel'),
(6, 'Feta'),
(6, 'Olivenöl'),
(6, 'Rosmarin'),

-- Brownies
(7, 'Zartbitterschokolade'),
(7, 'Butter'),
(7, 'Zucker'),
(7, 'Mehl'),
(7, 'Eier'),
(7, 'Meersalz'),

-- Lachs mit Zitronen-Dill-Sauce
(8, 'Lachsfilet'),
(8, 'Sahne'),
(8, 'Zitrone'),
(8, 'Dill'),
(8, 'Butter'),
(8, 'Salz'),
(8, 'Pfeffer');
