package controller;

import util.TupleUtil;

import java.lang.reflect.InvocationTargetException;

public class GameFactory {
    public static GameController createGame(Class<? extends GameController> gameClass, TupleUtil players) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return gameClass.getConstructor(TupleUtil.class).newInstance(players);
    }
//    public static GameController createGame(Class gameClass, TupleUtil players) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        return (GameController) gameClass.getConstructor(TupleUtil.class).newInstance(players);
//    }
}
