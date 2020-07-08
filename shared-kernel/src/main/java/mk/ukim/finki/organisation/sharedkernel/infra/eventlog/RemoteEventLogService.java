package mk.ukim.finki.organisation.sharedkernel.infra.eventlog;


import mk.ukim.finki.organisation.sharedkernel.domain.base.RemoteEventLog;


public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog();

}
