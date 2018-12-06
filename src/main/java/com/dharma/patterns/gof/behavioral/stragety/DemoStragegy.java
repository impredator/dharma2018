package com.dharma.patterns.gof.behavioral.stragety;

// 1. 算法接口（策略）
interface Strategy {
    void solve();
}

// 2. 算法实现
@SuppressWarnings("ALL")
abstract class StrategySolution implements Strategy {
    // 3. 模版方法
    public void solve() {
        start();
        while (nextTry() && !isSolution()) {
        }
        stop();
    }

    abstract void start();

    abstract boolean nextTry();

    abstract boolean isSolution();

    abstract void stop();
}

// 具体算法
class FOO extends StrategySolution {
    private int state = 1;

    protected void start() {
        System.out.print("Start  ");
    }

    protected void stop() {
        System.out.println("Stop");
    }

    protected boolean nextTry() {
        System.out.print("NextTry-" + state++ + "  ");
        return true;
    }

    protected boolean isSolution() {
        System.out.print("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}

// 2. 算法实现
abstract class StrategySearch implements Strategy {
    // 3. 模版方法
    public void solve() {
        while (true) {
            preProcess();
            if (search()) {
                break;
            }
            postProcess();
        }
    }

    abstract void preProcess();

    abstract boolean search();

    abstract void postProcess();
}

// 具体算法
@SuppressWarnings("ALL")
class BAR extends StrategySearch {
    private int state = 1;

    protected void preProcess() {
        System.out.print("PreProcess  ");
    }

    protected void postProcess() {
        System.out.print("PostProcess  ");
    }

    protected boolean search() {
        System.out.print("Search-" + state++ + "  ");
        return state == 3 ? true : false;
    }
}

// 4. 客户只关心接口
public class DemoStragegy {
    private static void execute(Strategy strategy) {
        strategy.solve();
    }

    public static void main(String[] args) {
        Strategy[] algorithms = {new FOO(), new BAR()};
        for (Strategy algorithm : algorithms) {
            execute(algorithm);
        }
    }
}

