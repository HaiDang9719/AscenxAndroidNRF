/*
 * Copyright (c) 2018, Nordic Semiconductor
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.example.odc.ascenxnrf.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import com.example.odc.ascenxnrf.BindAppKeysActivity;
import com.example.odc.ascenxnrf.MainActivity;
import com.example.odc.ascenxnrf.ManageAppKeysActivity;
import com.example.odc.ascenxnrf.ManageNodeAppKeysActivity;
import com.example.odc.ascenxnrf.MeshProvisionerActivity;
import com.example.odc.ascenxnrf.NodeConfigurationActivity;
import com.example.odc.ascenxnrf.ModelConfigurationActivity;
import com.example.odc.ascenxnrf.NodeDetailsActivity;
import com.example.odc.ascenxnrf.ProvisionedNodesScannerActivity;
import com.example.odc.ascenxnrf.ReconnectActivity;

@Module
abstract class ActivitiesModule {

	@ContributesAndroidInjector(modules = FragmentBuildersModule.class)
	abstract MainActivity contributeMainActivity();

	@ContributesAndroidInjector()
	abstract ManageAppKeysActivity contributeManageAppKeysActivity();

	@ContributesAndroidInjector()
	abstract MeshProvisionerActivity contributeMeshProvisionerActivity();

	@ContributesAndroidInjector()
	abstract NodeConfigurationActivity contributeElementConfigurationActivity();

	@ContributesAndroidInjector()
	abstract ModelConfigurationActivity contributeModelConfigurationActivity();

	@ContributesAndroidInjector()
	abstract ProvisionedNodesScannerActivity contributeScannerActivity();

	@ContributesAndroidInjector()
	abstract ReconnectActivity contributeReconnectActivity();

	@ContributesAndroidInjector()
	abstract NodeDetailsActivity contributeNodeDetailsActivity();

	@ContributesAndroidInjector()
	abstract ManageNodeAppKeysActivity contributeManageNodeAppKeysActivity();

	@ContributesAndroidInjector()
	abstract BindAppKeysActivity contributeBindAppKeysActivity();
}
