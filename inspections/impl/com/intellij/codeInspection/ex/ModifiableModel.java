/*
 * Copyright (c) 2000-2006 JetBrains s.r.o. All Rights Reserved.
 */

package com.intellij.codeInspection.ex;

import com.intellij.codeHighlighting.HighlightDisplayLevel;
import com.intellij.codeInsight.daemon.HighlightDisplayKey;
import com.intellij.codeInspection.InspectionProfileEntry;
import com.intellij.profile.Profile;

/**
 * User: anna
 * Date: 15-Feb-2006
 */
public interface ModifiableModel extends Profile {

  InspectionProfile getParentProfile();

  String getBaseProfileName();

  void setBaseProfile(InspectionProfile profile);

  String getName();

  void enableTool(String inspectionTool);

  void disableTool(String inspectionTool);

  void setErrorLevel(HighlightDisplayKey key, HighlightDisplayLevel level);

  HighlightDisplayLevel getErrorLevel(HighlightDisplayKey inspectionToolKey);

  boolean isToolEnabled(HighlightDisplayKey key);

  void commit();

  boolean isChanged();

  void setModified(final boolean toolsSettingsChanged);

  VisibleTreeState getExpandedNodes();

  boolean isProperSetting(HighlightDisplayKey key);

  void resetToBase();

  InspectionProfileEntry getInspectionTool(String shortName);

  InspectionProfileEntry[] getInspectionTools();

  void copyFrom(InspectionProfile profile);

  void inheritFrom(InspectionProfile profile);

  boolean isDefault();

  void initInspectionTools();

  boolean isExecutable();

  void setEditable(String toolDisplayName);
}
