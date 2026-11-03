package com.bornfire.xbrl.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.Forward_reveal_manual_rep;
import com.bornfire.xbrl.entities.Mis_treasury_placement_repo;
import com.bornfire.xbrl.entities.RT_ACPRNF_REPO;
import com.bornfire.xbrl.entities.RT_ACPR_REPO;
import com.bornfire.xbrl.entities.RT_FX_Position_Rep;
import com.bornfire.xbrl.entities.RT_MID_FX_DEAL_REPO;
import com.bornfire.xbrl.entities.RT_RWA_Fund_base_data_rep;
import com.bornfire.xbrl.entities.RT_RWA_NonFund_base_data_rep;
import com.bornfire.xbrl.entities.RT_SLS_BEHAVIOURAL_PER_REP;
import com.bornfire.xbrl.entities.RT_Treasury_master_tb_repo;
import com.bornfire.xbrl.entities.RT_Treasury_swd_data_repo;
import com.bornfire.xbrl.entities.RT_Overnight_Foreign_Ccy_Data_Repo;
import com.bornfire.xbrl.entities.RtInvestmentDealDataDump_Rep;
import com.bornfire.xbrl.entities.RtPlacementDealDataDump_Rep;
import com.bornfire.xbrl.entities.Daylight_data_repo;

/**
 * Deletes uploaded regulatory data by report type and report date (used after delete approval).
 */
@Service
public class UploadDataDeleteService {

    @Autowired
    private RT_ACPR_REPO rtAcprRepo;
    @Autowired
    private RT_ACPRNF_REPO rtAcprnfRepo;
    @Autowired
    private RT_RWA_Fund_base_data_rep fundRepo;
    @Autowired
    private RT_RWA_NonFund_base_data_rep nonFundRepo;
    @Autowired
    private RT_FX_Position_Rep rtFxPositionRep;
    @Autowired
    private RT_SLS_BEHAVIOURAL_PER_REP rtSlsRepository;
    @Autowired
    private RT_MID_FX_DEAL_REPO midFxDealRepo;
    @Autowired
    private Mis_treasury_placement_repo placementRepo;
    @Autowired
    private RT_Treasury_master_tb_repo tbMasterRepo;
    @Autowired
    private RT_Treasury_swd_data_repo trSwdRepo;
    @Autowired
    private Forward_reveal_manual_rep forwardRepo;
    @Autowired
    private RtInvestmentDealDataDump_Rep investmentDealDumpRepo;
    @Autowired
    private RtPlacementDealDataDump_Rep placementDealDumpRepo;
    @Autowired
    private Daylight_data_repo daylightDataRepo;
    @Autowired
    private RT_Overnight_Foreign_Ccy_Data_Repo overnightForeignCcyRepo;
    @Autowired
    private ECLDataUploadService eclDataUploadService;
    @Autowired
    private SMAFileUploadService smaFileUploadService;
    @Autowired
    private ProvisioningFileUploadService provisioningFileUploadService;
    @Autowired
    private RwaDataUploadService rwaDataUploadService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void deleteUploadedData(String reportType, Date reportDate) {
        if (reportType == null || reportType.trim().isEmpty()) {
            throw new RuntimeException("Report type is required to delete uploaded data.");
        }
        if (reportDate == null) {
            throw new RuntimeException("Report date is required to delete uploaded data.");
        }

        java.sql.Date sqlDate = new java.sql.Date(reportDate.getTime());
        switch (reportType) {
            case "ACPR":
                rtAcprRepo.deleteByReportDate(reportDate);
                break;
            case "ACPRNF":
                rtAcprnfRepo.deleteByReportDate(reportDate);
                break;
            case "RWAFUND":
                fundRepo.deleteByReportDate(reportDate);
                break;
            case "RWANONFUND":
                nonFundRepo.deleteByReportDate(reportDate);
                break;
            case "RWABILLDETAIL":
                rwaDataUploadService.deleteBillDataByReportDate(reportDate);
                break;
            case "FXP":
                rtFxPositionRep.deleteByReportDate(reportDate);
                break;
            case "SLS":
                rtSlsRepository.deleteByReportDate(reportDate);
                break;
            case "MFD":
                midFxDealRepo.deleteByReportDate(reportDate);
                break;
            case "GAMDATADUMP":
                rwaDataUploadService.deleteGamDataByReportDate(reportDate);
                break;
            case "ONLY_EAB_TABLE_DATA":
                rwaDataUploadService.deleteEabDataByReportDate(reportDate);
                break;
            case "TR_PLC":
                placementRepo.Deletebydaterecord(reportDate);
                break;
            case "TR_TB":
                tbMasterRepo.Deletebydate(reportDate);
                break;
            case "TR_SWD":
                trSwdRepo.Deletebyreportdate(reportDate);
                break;
            case "FWD_RVL":
                forwardRepo.Deletebyreportdate(reportDate);
                break;
            case "TR_INV_DEAL_DUMP":
                investmentDealDumpRepo.deleteByReportDate(reportDate);
                break;
            case "plcdealdump":
                placementDealDumpRepo.deleteByReportDate(reportDate);
                break;
            case "ECL":
                eclDataUploadService.deleteByReportDate(reportDate);
                break;
            case "SMA":
                smaFileUploadService.deleteByReportDate(reportDate);
                break;
            case "Provisioning":
                provisioningFileUploadService.deleteByReportDate(reportDate);
                break;
            case "VARFILE":
                jdbcTemplate.update(
                        "DELETE FROM RT_VAR_PORTFOLIO_TABLE WHERE TRUNC(REPORT_DATE)=TRUNC(?)", sqlDate);
                break;
            case "DAY_LIGHT":
                daylightDataRepo.Deletedetail(reportDate);
                break;
            case "ONFC":
                overnightForeignCcyRepo.deleteByReportDate(reportDate);
                break;
            default:
                throw new RuntimeException("Delete is not supported for report type: " + reportType);
        }
    }
}
