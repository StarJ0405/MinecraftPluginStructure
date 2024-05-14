package shining.starj.structure.Entities.Animal;

import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.animal.EntityWolf;
import net.minecraft.world.level.World;

public class CustomWolf extends EntityWolf{

    // 커스텀 NPC자체 생성
    public CustomWolf(World world) {
            /* EntityTypes
             방법 1 이름으로 불러오기 (이름은 해당 클래스 내에서 확인 가능)
                 (EntityTypes<? extends EntityWolf>) EntityTypes.a("wolf").get()
             방법 2 목록에서 찾기
                EntityTypes.bp
            */
            /* World
                net.minecraft.world.level.World
                ((CraftWorld) loc.getWorld()).getHandle();
                이때 loc.getWorld()는 org.bukkit.World
                 CraftWorld는  org.bukkit.craftbukkit.버전.CraftWorld;
             */
        super((EntityTypes<? extends EntityWolf>) (EntityTypes.a("wolf").isPresent() ? EntityTypes.a("wolf").get() : EntityTypes.bp), world);
    }
        /*
        변경할 내용들은 클래스 내부 파일을 참고하여 수정하길 바람.
            AI변경
                Pathfinder를 통하여 기본 행동 방식 변경 가능
                PathfinderGoalSelector의 등록하는 방식으로 작동
            작동 변경
                일부 함수를 수정하여 같은 결과에서 다른 결과 도출 가능
                상호 작용 등등
            스탯 변경
                1. 부모 클래스에서 AttributeProvider.Builder 제공하는 형태로 지정
                2. 엔티티 생성 후 Attribute를 통하여 선 생성 후 수정
         */
}
