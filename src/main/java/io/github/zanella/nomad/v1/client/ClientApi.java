package io.github.zanella.nomad.v1.client;

import io.github.zanella.nomad.v1.client.models.AllocationFile;
import io.github.zanella.nomad.v1.client.models.AllocationStats;
import io.github.zanella.nomad.v1.client.models.LogStream;
import io.github.zanella.nomad.v1.client.models.Stats;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface ClientApi {
    String statsUrl = "/v1/client/stats";

    @RequestLine("GET " + statsUrl)
    Stats getStats();

    String allocationStatsUrl = "/v1/client/allocation/{allocationId}/stats";

    @RequestLine("GET " + allocationStatsUrl)
    AllocationStats getAllocationStats(@Param("allocationId") String allocationId);

    String allocationFileListUrl = "/v1/client/fs/ls/{allocationId}?path={path}";

    @RequestLine("GET " + allocationFileListUrl)
    List<AllocationFile> getAllocationFileList(@Param("allocationId") String allocationId, @Param("path") String path);

    String allocationFileStatsUrl = "/v1/client/fs/stat/{allocationId}?path={path}";

    @RequestLine("GET " + allocationFileStatsUrl)
    AllocationFile getAllocationFileStats(@Param("allocationId") String allocationId, @Param("path") String path);

    String allocationFileContentUrl = "/v1/client/fs/readat/{allocationId}?path={path}&offset=0";

    @RequestLine("GET " + allocationFileContentUrl)
    byte[] getAllocationFileContent(@Param("allocationId") String allocationId, @Param("path") String path);

    String allocationFileContentOffsetUrl = "/v1/client/fs/readat/{allocationId}?path={path}&offset={offset}&limit={limit}";

    @RequestLine("GET " + allocationFileContentOffsetUrl)
    byte[] getAllocationFileContent(@Param("allocationId") String allocationId, @Param("path") String path,
                                    @Param("offset") int offset, @Param("limit") int limit);

    String allocationLogStreamUrl = "/v1/client/fs/logs/{allocationId}?task={task}&follow={follow}&type={type}&offset={offset}&origin={origin}&plain={plain}";

    @RequestLine("GET " + allocationLogStreamUrl)
    List<LogStream> getAllocationLogStreamsList(@Param("allocationId") String allocationId, @Param("task") String task,
                                                @Param("follow") Boolean follow, @Param("type") LogStream.Type type,
                                                @Param("offset") int offset, @Param("origin") LogStream.Origin origin, @Param("plain") Boolean plain);
}
