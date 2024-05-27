package shining.starj.structure.Predicates;

import lombok.Builder;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import shining.starj.structure.Predicates.Conditions.*;

import java.util.List;
import java.util.Optional;


public class CommandPredicate implements java.util.function.Predicate<Entity> {
    private final DistanceCondition distanceCondition;
    private final CoordinateCondition coordinateCondition;
    private final List<ScoreCondition> scoreConditionList;
    private final LevelCondition levelCondition;
    private final GameModeCondition gameModeCondition;
    private final NameCondition nameCondition;
    private final TagCondition tagCondition;
    private final TypeCondition typeCondition;
    // https://namu.wiki/w/%EB%A7%88%EC%9D%B8%ED%81%AC%EB%9E%98%ED%94%84%ED%8A%B8/%EB%AA%85%EB%A0%B9%EC%96%B4/%EB%8C%80%EC%83%81%20%EC%84%A0%ED%83%9D%20%EC%9D%B8%EC%9E%90
    @Getter
    private final Integer limit;

    @Builder
    public CommandPredicate(DistanceCondition distanceCondition, String world, Double x, Double y, Double z, Double dx, Double dy, Double dz, List<ScoreCondition> scoreConditionList, LevelCondition levelCondition, GameModeCondition gameModeCondition, NameCondition nameCondition, TagCondition tagCondition, TypeCondition typeCondition, Integer limit) {
        this.distanceCondition = distanceCondition;
        this.coordinateCondition = CoordinateCondition.builder().world(Bukkit.getWorld(Optional.ofNullable(world).orElse(""))).x(x).y(y).z(z).dx(dx).dy(dy).dz(dz).build();
        this.scoreConditionList = scoreConditionList;
        this.levelCondition = levelCondition;
        this.gameModeCondition = gameModeCondition;
        this.nameCondition = nameCondition;
        this.tagCondition = tagCondition;
        this.typeCondition = typeCondition;
        this.limit = limit;
    }

    @Override
    public boolean test(Entity entity) {
        if (this.distanceCondition != null && !this.distanceCondition.is(entity)) return false;
        if (coordinateCondition != null && !coordinateCondition.is(entity)) return false;
        for (ScoreCondition scoreCondition : scoreConditionList)
            if (scoreCondition != null && !scoreCondition.is(entity)) return false;
        if (levelCondition != null && !levelCondition.is(entity)) return false;
        if (gameModeCondition != null && !gameModeCondition.is(entity)) return false;
        if (nameCondition != null && !nameCondition.is(entity)) return false;
        if (tagCondition != null && !tagCondition.is(entity)) return false;
        return typeCondition == null || typeCondition.is(entity);
    }

}