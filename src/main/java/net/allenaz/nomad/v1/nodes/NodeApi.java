package net.allenaz.nomad.v1.nodes;

import feign.Param;
import feign.RequestLine;
import net.allenaz.nomad.v1.nodes.models.NodeAllocation;
import net.allenaz.nomad.v1.nodes.models.NodeInfo;

import java.util.List;

public interface NodeApi {
    @RequestLine("GET /v1/node/{nodeId}")
    NodeInfo getNode(@Param("nodeId") String nodeId);

    @RequestLine("GET /v1/node/{nodeId}?region={region}")
    NodeInfo getNodeForRegion(@Param("nodeId") String nodeId, @Param("region") String region);

    @RequestLine("GET /v1/node/{nodeId}/allocations")
    List<NodeAllocation> getNodeAllocations(@Param("nodeId") String nodeId);
}