package ca.bc.gov.open.pssg.rsbc.dps.sftp.starter;

import java.io.ByteArrayInputStream;

public interface SftpService {

    ByteArrayInputStream getContent(String remoteFilename) throws DpsSftpException;

    void moveFile(String remoteFilename, String destinationFilename) throws DpsSftpException;

}
