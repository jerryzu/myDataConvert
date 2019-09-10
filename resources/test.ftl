root.put("name", "${name}");
root.put("age", "${age}");
<#list students as student>
${student.id}
${student.name}
${student.teacher}
${student.teachers.id}
${student.teachers.name}
</#list>