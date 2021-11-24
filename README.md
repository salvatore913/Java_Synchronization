## Задача 1. Автосалон

### Описание
Мы узнали про синхронизацию потоков и варианты ее исполнения. Попробуем написать что-то, с использованием пройденного.

Начнем с реализации похожей на лекционный пример задачи. У нас есть производитель товара (например, машин) и потребитель (покупатель). Покупатель хочет купить товар, но может это сделать только тогда, когда он есть в наличии (производитель его сделал/создал)

Вы сами должны определить объект синхронизации для ваших действий и сами должны описать необходимые классы. Ограничения: производитель и покупатель являются потоками. Программа не должна быть слишком сложной (не стоит описывать все характеристики авто в классе, мы их здесь не используем, так что применяйте принцип абстракции)

### Работа программы
1. Создание потока-производителя и потока-покупателя
2. Покупатель покупает товар, если это возможно
3. С некоторой периодичностью производитель выкладывает товар на рынок

### Требования к программе
1. Каждый ключевой этап должен сопровождаться выводом в консоль текущего статуса, например: Производитель Toyota выпустил 1 автомобиль
2. Все задержки (время сборки авто, таймаут желания купить машину) должны быть оформлены в константах (никаких "Магических чисел")
3. Должно быть несколько потоков-покупателей, которые будут желать несколько раз купить машину. Производитель выпускает по 1 машине. Программу можно завершать после продажи 10 машин

### Пример
```
Покупатель1 зашел в автосалон
Машин нет
Покупатель3 зашел в автосалон
Машин нет
Покупатель2 зашел в автосалон
Машин нет
Производитель Toyota выпустил 1 авто
Покупатель2 уехал на новеньком авто
Производитель Toyota выпустил 1 авто
Покупатель1 уехал на новеньком авто
Покупатель2 зашел в автосалон
Машин нет
Производитель Toyota выпустил 1 авто
Покупатель3 уехал на новеньком авто
...
```

<details>
  <summary>Подсказка</summary>
  
  Используйте методы wait() и notify() для реализации ожиданий и уведомлений.
  
  Если возникают затруднения, посмотрите код из лекции с магазином
</details>

