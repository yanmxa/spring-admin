package com.nood.hrm.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nood.hrm.dto.DepartmentDto;
import com.nood.hrm.model.Permission;

import java.util.List;
import java.util.stream.Collectors;

public class TreeUtil {

    /**
     * 菜单树
     *
     * @param parentId
     * @param allPermission
     * @param array
     */
    public static void setPermissionsTree(Integer parentId, List<Permission> allPermission, JSONArray array) {

        for (Permission current : allPermission) {
            if (current.getParentId().equals(parentId)) {

                String string = JSONObject.toJSONString(current);
                JSONObject parent = (JSONObject) JSONObject.parse(string);
                array.add(parent);

                if (allPermission.stream().filter(p -> p.getParentId().equals(current.getId())).findAny() != null) {
                    JSONArray child = new JSONArray();
                    parent.put("child", child);
                    setPermissionsTree(current.getId(), allPermission, child);
                }

            }
        }

    }


    public static List<DepartmentDto> deptTree(List<DepartmentDto> listById, List<DepartmentDto> lists ){
        // if (listByRoleId == null & listByRoleId.size() ==0){
        //     throw
        // }
        List<Integer> collect = listById.stream().map(DepartmentDto::getId).collect(Collectors.toList());
        List<Integer> collect1 = lists.stream().map(DepartmentDto::getId).collect(Collectors.toList());
        // 遍历list2
        for (Integer item : collect) {
            // 如果存在这个数
            if (collect1.contains(item)) {
                DepartmentDto deptDto = new DepartmentDto();
                int i = collect1.indexOf(item);
                deptDto = lists.get(i);
                deptDto.setCheckArr("1");
                lists.set(i, deptDto);
            }
        }
        return lists;
    }
}
