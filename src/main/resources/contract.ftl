<#list contracts as c>
${c.contractid}
${c.contractno}
${c.contact}
${c.city}
${c.prodid}
${c.address}
${c.remark!""}
<#list c.contractitems as d>
${d.itemname!""}
${d.brandname}
${d.modelnumber}
${d.specs}
${d.unitprice}
${d.quotedprice}
${d.picture!""}
${d.setuppicture!""}
${d.remark!""}
</#list>
</#list>