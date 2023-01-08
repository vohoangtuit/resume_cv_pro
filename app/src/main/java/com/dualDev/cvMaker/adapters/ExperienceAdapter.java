package com.dualDev.cvMaker.adapters;

import androidx.annotation.NonNull;

import com.dualDev.cvMaker.datamodel.Experience;

import java.util.List;



public class ExperienceAdapter extends ResumeEventAdapter<Experience> {

    public ExperienceAdapter(@NonNull List<Experience> list,
                             ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}
