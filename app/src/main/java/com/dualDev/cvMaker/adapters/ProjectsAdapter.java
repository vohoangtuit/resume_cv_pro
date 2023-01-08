package com.dualDev.cvMaker.adapters;

import androidx.annotation.NonNull;
import android.view.View;

import com.dualDev.cvMaker.datamodel.Project;

import java.util.List;


public class ProjectsAdapter extends ResumeEventAdapter<Project> {

    public ProjectsAdapter(@NonNull List<Project> list,
                           ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }

    @Override
    protected void updateViewHolder(ResumeEventAdapterViewHolder viewHolder) {
        viewHolder.subtitle.setVisibility(View.GONE);
    }
}