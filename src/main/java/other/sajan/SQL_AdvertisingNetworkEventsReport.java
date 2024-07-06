package other.sajan;

public class SQL_AdvertisingNetworkEventsReport {
    /**
     select
     c.name,
     count(*),
     CAST(avg(e.value) AS DECIMAL(16,5))
     from campaigns c inner join events e on c.id = e.campaign_id
     where e.dt like '2022-07-15 %'
     group by c.name
     having avg(e.value) >= 0.7
     order by avg(e.value) desc;
     */
}
