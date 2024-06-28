# Bot Simsimi Java

## require

- `java`
- `maven`

## install

```bash
sudo pacman -S jdk-openjdk maven
```

## build

```bash
mvn clean install
```

## jalankan

```bash
mvn exec:java -Dexec.mainClass="com.jembot.App"
```

atau

```bash
java -jar target/jembot-1.0.jar
```
