# Units_java
Units  java classes 

Юниты, наносящие физический урон:

    Soldier [Солдат] : юнит без всяких специальных возможностей
    Rogue [Разбойник] : разбойника невозможно контратаковать
    Berserker [Берсерк] : на берсеркера не действует магия
    Vampire [Вампир] : при атаке / контратаке потребляет часть жизненных сил противника
    Werewolf [Оборотень] : умеет превращаться в волка (в состоянии волка имеет более высокий показатель жизненных сил и атаки, но получает больший урон от магии)

Юниты, способные к магии:

    Wizard [Волшебник] : атакует боевыми заклинаниями (лечебные заклинания имеют только половину силы)
    Healer [Целитель] : владеет целебными заклинаниями (боевые заклинания имеют только половину силы)
    Priest [Священник] : владеет целебными заклинаниями (боевые заклинания имеют только половину силы), наносит x2 урон нежити (Vampire, Necromancer)
    Warlock [Чернокнижник] : призывает демонов (класс Demon немного расширяет класс Soldier)
    Necromancer [Некромант] : следит за всеми кого атаковал, в случае смерти атакованого юнита, получает часть его жизненных сил.

devclub.com.ua (c)
