# LLD Concepts

This repository contains Java implementations of low-level design examples, common design patterns, and machine coding problems.

## Tech Stack

- Java 26
- Maven
- Package root: `org.example`

## Repository Structure

```text
lld-concepts/
|-- pom.xml
|-- README.md
|-- src/main/java/org/example/
|   |-- Main.java
|   |-- chainOfResponsibility/
|   |-- decoratorPattern/
|   |-- factoryDesignPattern/
|   |-- observerPattern/
|   |-- strategyPattern/
|   |-- questions/
|       |-- atm/
|       |-- chess/
|       |-- designElevator/
|       |-- designTickTacToe/
|       |-- splitwise/
```

Generated folders such as `target/`, `out/`, and IDE metadata under `.idea/` are not part of the source map.

## Design Pattern Examples

| Package | Concept | Main Classes |
|---|---|---|
| `chainOfResponsibility` | Chain of Responsibility for log handling | `LogProcessor`, `InfoLogProcessor`, `DebugLogProcessor`, `ErrorLogProcessor`, `FatalLogProcessor`, `LogDemo` |
| `decoratorPattern` | Decorator pattern for pizza toppings | `BasePizza`, `PlainPizza`, `ToppingDecorator`, `ExtraCheeseTopping`, `MushroomTopping`, `PepperoniTopping`, `VeggiesTopping`, `PizzaShop` |
| `factoryDesignPattern` | Factory method for notifications | `Notification`, `EmailNotification`, `SMSNotification`, `PushNotification`, `NotificationCreator`, `factoryDemo` |
| `observerPattern` | Observer pattern for fitness data updates | `FitnessDataSubject`, `FitnessDataObserver`, `FitnessData`, `GoalNotifier`, `LiveActivityDisplay`, `ProgressLogger`, `FitnessAppObserverDemo` |
| `strategyPattern` | Strategy pattern for shipping cost calculation | `ShippingStrategy`, `ShippingCostService`, `FlatRateShipping`, `WeightBasedShipping`, `DistanceBasedShipping`, `ThirdPartyApiShipping`, `ECommerceAppV2` |

## LLD Problem Examples

### ATM

Package: `org.example.questions.atm`

Contains an ATM design using state objects and withdrawal processors.

Key areas:
- `ATMroomComponent`: `ATM`, `ATMroom`, `BankAccount`, `Card`, `User`
- `states`: `ATMState`, `IdleState`, `HasCardState`, `SelectOpState`, `CashWithdrawState`, `CheckBalanceState`
- `AmountWithdraw`: `CashWithdrawProcessor`, `TwoThousandWithdrawProcessor`, `FiveHundredWithdrawProcessor`, `OneHundredWithdrawProcessor`
- `enums`: `TransactionType`

### Chess

Package: `org.example.questions.chess`

Contains a basic chess game model with board, cells, players, moves, pieces, and game status.

Key classes:
- Core: `ChessDemo`, `Game`, `Board`, `Cell`, `Move`, `Player`, `Position`
- Pieces: `Piece`, `King`, `Queen`, `Bishop`, `Knight`, `Rook`, `Pawn`
- Enums: `GameStatus`, `PieceColor`, `PieceType`
- UML doc: `src/main/java/org/example/questions/chess/ChessGameUML.md`

### Elevator

Package: `org.example.questions.designElevator`

Contains an elevator system model with elevator cars, floors, buttons, dispatchers, controllers, and selection strategies.

Key classes:
- Core: `Building`, `Floor`, `ElevatorCar`, `Door`, `elevatorMain`
- Control: `ElevatorController`, `ElevatorScheduler`, `ExternalDispatcher`, `InternalDispatcher`
- Buttons: `ExternalButton`, `InternalButton`
- Strategies: `ElevatorSelectionStrategy`, `NearestElevatorStrategy`, `LeastBusyStrategy`
- Enums: `Direction`, `DoorState`

### Splitwise

Package: `org.example.questions.splitwise`

Contains an expense sharing model with users, groups, expenses, split strategies, balance sheets, and debt simplification.

Key areas:
- Core: `Splitwise`, `Demo`, `SimplifyDebtAlgo`
- User/group: `User`, `UserController`, `Group`, `GroupController`
- Expense: `Expense`, `ExpenseController`, `SplitFactory`, `SplitType`
- Splits: `Split`, `ExpenseSplit`, `EqualExpenseSplit`, `UnequalExpenseSplit`, `PercentageExpenseSplit`
- Balance sheet: `Balance`, `BalanceSheet`, `BalanceSheetController`

### Tic Tac Toe

Package: `org.example.questions.designTickTacToe`

This package currently exists as a placeholder and has no Java source files.

## Useful Entry Points

| Example | Class |
|---|---|
| Chain of Responsibility | `org.example.chainOfResponsibility.LogDemo` |
| Decorator Pattern | `org.example.decoratorPattern.PizzaShop` |
| Factory Pattern | `org.example.factoryDesignPattern.factoryDemo` |
| Observer Pattern | `org.example.observerPattern.FitnessAppObserverDemo` |
| Strategy Pattern | `org.example.strategyPattern.ECommerceAppV2` |
| Chess | `org.example.questions.chess.ChessDemo` |
| Elevator | `org.example.questions.designElevator.elevatorMain` |
| Splitwise | `org.example.questions.splitwise.Demo` |

## Build

Compile the project:

```bash
mvn compile
```

Run a compiled demo class from the project root:

```bash
java -cp target/classes org.example.questions.chess.ChessDemo
```
