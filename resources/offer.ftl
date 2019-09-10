<#list offers as o>
${o.offerid}
${o.offerno}
${o.inquirer!""}
${o.amount}
${o.contact}
${o.city}
${o.prodid}
${o.address}
${o.remark}
<#list o.offeritems as offeritem>
${offeritem.offeritemid}
${offeritem.offerid}
${offeritem.itemid}
${offeritem.itemname}
${offeritem.brandname}
${offeritem.modelnumber}
${offeritem.specs}
${offeritem.unitprice}
${offeritem.quotedprice}
${offeritem.picture}
${offeritem.setuppicture}
${offeritem.remark}
</#list>
</#list>