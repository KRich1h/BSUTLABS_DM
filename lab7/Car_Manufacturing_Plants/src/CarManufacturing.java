// 1. Интерфейсы для семейств продуктов (автомобилей)
interface Sedan {
    void drive();
}

interface SUV {
    void drive();
}

interface ElectricCar {
    void drive();
}

// 2. Конкретные реализации продуктов для разных брендов
// Toyota продукты
class ToyotaSedan implements Sedan {
    @Override
    public void drive() {
        System.out.println("Driving Toyota Camry");
    }
}

class ToyotaSUV implements SUV {
    @Override
    public void drive() {
        System.out.println("Driving Toyota RAV4");
    }
}

class ToyotaElectric implements ElectricCar {
    @Override
    public void drive() {
        System.out.println("Driving Toyota bZ4X");
    }
}

// Ford продукты
class FordSedan implements Sedan {
    @Override
    public void drive() {
        System.out.println("Driving Ford Fusion");
    }
}

class FordSUV implements SUV {
    @Override
    public void drive() {
        System.out.println("Driving Ford Explorer");
    }
}

class FordElectric implements ElectricCar {
    @Override
    public void drive() {
        System.out.println("Driving Ford Mustang Mach-E");
    }
}

// 3. Абстрактная фабрика
interface CarFactory {
    Sedan createSedan();
    SUV createSUV();
    ElectricCar createElectricCar();
}

// 4. Конкретные фабрики для каждого бренда
class ToyotaFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new ToyotaSedan();
    }

    @Override
    public SUV createSUV() {
        return new ToyotaSUV();
    }

    @Override
    public ElectricCar createElectricCar() {
        return new ToyotaElectric();
    }
}

class FordFactory implements CarFactory {
    @Override
    public Sedan createSedan() {
        return new FordSedan();
    }

    @Override
    public SUV createSUV() {
        return new FordSUV();
    }

    @Override
    public ElectricCar createElectricCar() {
        return new FordElectric();
    }
}

// 5. Клиентский код
public class CarManufacturing {
    public static void main(String[] args) {
        // Создаем фабрику Toyota
        CarFactory toyotaFactory = new ToyotaFactory();

        // Производим автомобили Toyota
        Sedan toyotaSedan = toyotaFactory.createSedan();
        SUV toyotaSUV = toyotaFactory.createSUV();
        ElectricCar toyotaElectric = toyotaFactory.createElectricCar();

        // Тестируем автомобили Toyota
        System.out.println("Toyota cars:");
        toyotaSedan.drive();
        toyotaSUV.drive();
        toyotaElectric.drive();

        // Создаем фабрику Ford
        CarFactory fordFactory = new FordFactory();

        // Производим автомобили Ford
        Sedan fordSedan = fordFactory.createSedan();
        SUV fordSUV = fordFactory.createSUV();
        ElectricCar fordElectric = fordFactory.createElectricCar();

        // Тестируем автомобили Ford
        System.out.println("\nFord cars:");
        fordSedan.drive();
        fordSUV.drive();
        fordElectric.drive();
    }
}