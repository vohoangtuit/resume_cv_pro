package com.dualDev.cvMaker.adapters;

import androidx.annotation.NonNull;

import com.dualDev.cvMaker.datamodel.School;

import java.util.List;



public class SchoolsAdapter extends ResumeEventAdapter<School> {

    public SchoolsAdapter(@NonNull List<School> list,
                          ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}