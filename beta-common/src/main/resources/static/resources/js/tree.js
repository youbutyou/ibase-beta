
/**
 * 树形转换（tree）
 */
function treeLoadFilter(data,spread){
    var rootNodes=[];
    for(var i=0;i<data.length;i++){
        var oneData=data[i];
        if(!exists(data,oneData.psn)){
            rootNodes.push({
                title:oneData.iname,
                id:oneData.sn,
                href:oneData.url,
                 spread:spread
                // originData:oneData
            });
        }
    }
    var nodes=[];
    for(var i=0;i<rootNodes.length;i++){
        nodes.push(rootNodes[i]);
    }
    while(0<nodes.length){
        var node=nodes.shift();
        for(var i=0;i<data.length;i++){
            var oneData=data[i];
            if(oneData.psn==node.id){
                var child={
                    title:oneData.iname,
                    id:oneData.sn,
                    href:oneData.url,
                    spread:spread
                    // originData:oneData
                };
                if(null!=node.children){
                    node.children.push(child);
                }else{
                    node.children=[child];
                }
                node.spread=spread;
                nodes.push(child);
            }
        }
    }
    function exists(data,psn){
        if(null!=data){
            for(var i=0;i<data.length;i++){
                var oneData=data[i];
                if(oneData.sn==psn){
                    return true;
                }
            }
        }
        return false;
    }
    return rootNodes;
}