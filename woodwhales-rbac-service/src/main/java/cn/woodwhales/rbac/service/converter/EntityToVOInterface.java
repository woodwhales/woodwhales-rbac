package cn.woodwhales.rbac.service.converter;

/**
 * 数据库实体对象转 VO 对象
 * @author woodwhales
 * @param <Entity>
 * @param <VO>
 */
public interface EntityToVOInterface<Entity, VO> {

    /**
     * entity 转 vo
     * @param entity
     * @return
     */
    VO convertToVO(Entity entity);

}
