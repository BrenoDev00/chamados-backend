package com.projects.chamados.constants;

import com.projects.chamados.enums.EquipmentType;
import com.projects.chamados.models.Equipment;

import java.util.UUID;

public class EquipmentConstants {
    public static final UUID EQUIPMENT_ID = UUID.randomUUID();
    public static final Equipment EQUIPMENT_ONE = new Equipment(null, "BR 070 DF", "123abc", EquipmentType.WIM, "001ab", TechnicianConstants.TECHNICIAN_ONE);
}
