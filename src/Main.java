/*
Паттерн "Мост" (Bridge) - это структурный паттерн проектирования,
который позволяет разделять абстракцию от ее реализации, чтобы они могли изменяться независимо.
Такой подход позволяет изменять сущности независимо друг от друга.

Назначение паттерна Bridge:
    Паттерн Bridge предназначен для того, чтобы разделить абстракцию и реализацию таким образом,
    чтобы они могли изменяться независимо. Это особенно полезно, когда абстракция и реализация могут изменяться независимо друг от друга.

Структура паттерна Bridge:
    Абстракция (Abstraction): Определяет интерфейс высокоуровневых операций,
    которые должны быть доступны клиентам. Взаимодействует с реализацией через объект Реализации.

    Реализация (Implementor): Определяет интерфейс для низкоуровневых операций,
    которые должны быть доступны Абстракции. Этот интерфейс не обязательно должен совпадать с интерфейсом Абстракции.
    Реализация не зависит от деталей интерфейса Абстракции.

    Уточненная Абстракция (Refined Abstraction): Расширяет интерфейс Абстракции и может добавлять свою логику.

    Конкретная Реализация (Concrete Implementor): Предоставляет конкретную реализацию интерфейса Implementor.т
*/

public class Main {
    public static void main(String[] args) {
        // строим небоскребы и дома из глины и камня
        BuildingBuilder building1 = new BuildHouse(new Clay(), 200);
        building1.Build();
        BuildingBuilder building2 = new BuildHouse(new Stone(), 200);
        building2.Build();
        BuildingBuilder building3 = new BuildSkycraper(new Clay(), 200);
        building3.Build();
        BuildingBuilder building4 = new BuildSkycraper(new Stone(), 200);
        building4.Build();
    }
}

interface IMaterial {
    public void Prepare();
}

class Stone implements IMaterial {

    @Override
    public void Prepare() {
        System.out.println("Stones are prepared.");
    }
}

class Clay implements IMaterial {

    @Override
    public void Prepare() {
        System.out.println("Clay is prepared.");
    }
}

abstract class BuildingBuilder {
    protected IMaterial material;
    protected double area;

    BuildingBuilder(IMaterial material, double area) {
        this.material = material;
        this.area = area;
    }

    public abstract void Build();
}

class BuildHouse extends BuildingBuilder {
    BuildHouse(IMaterial material, double area) {
        super(material, area);
    }

    @Override
    public void Build() {
        material.Prepare();
        System.out.println("House is built." + '\n');
    }
}

class BuildSkycraper extends BuildingBuilder {
    BuildSkycraper(IMaterial material, double area) {
        super(material, area);
    }

    @Override
    public void Build() {
        material.Prepare();
        System.out.println("Skycraper is built." + '\n');
    }
}