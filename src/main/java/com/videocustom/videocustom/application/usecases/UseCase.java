package com.videocustom.videocustom.application.usecases;

public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN input);
}
