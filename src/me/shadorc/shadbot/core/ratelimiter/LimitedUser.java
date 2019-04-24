package me.shadorc.shadbot.core.ratelimiter;

import io.github.bucket4j.Bucket;

import java.util.concurrent.atomic.AtomicBoolean;

public class LimitedUser {

    private final Bucket bucket;
    private final AtomicBoolean isWarned;

    public LimitedUser(Bucket bucket) {
        this.bucket = bucket;
        this.isWarned = new AtomicBoolean(false);
    }

    public Bucket getBucket() {
        return this.bucket;
    }

    public boolean isWarned() {
        return this.isWarned.get();
    }

    public void warn() {
        this.isWarned.set(true);
    }

    public void unwarn() {
        this.isWarned.set(false);
    }

}
