            root.put("name", "${name}");
            root.put("age", "${age}");
<#list students as student>
    ${student.id}
    ${student.name}
    ${student.teacher}
</#list>